package com.cly.test.sockettest;

import ch.qos.logback.core.net.SocketConnector;
import com.cly.test.controller.Lock.LockService;
import lombok.extern.slf4j.Slf4j;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.*;

@Slf4j
public class SocketMain {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        try {
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            ServerSocket serverSocket=serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(8090));
            serverSocketChannel.configureBlocking(false);
            Selector selector1=Selector.open();
            serverSocketChannel.register(selector1,SelectionKey.OP_ACCEPT);
            int selectNum=selector1.select();
            SelectionKey selectionKey=null;
            if(selectNum>0){
                Set<SelectionKey> sks=selector1.keys();
                for(SelectionKey  sk:sks){
                    if(sk.isAcceptable()){
                        ServerSocketChannel serverSocketChannel1=(ServerSocketChannel)sk.channel();
                        SocketChannel socketChannel=serverSocketChannel1.accept();
                        socketChannel.configureBlocking(false);
                        selectionKey.interestOps(SelectionKey.OP_READ);

                    }
                }
            }

           /* SocketChannel sc=SocketChannel.open();
            sc.configureBlocking(false);
            Selector selector=Selector.open();
            sc.register(selector, SelectionKey.OP_CONNECT);
            int num=selector.select(1000);
            SelectionKey sk=null;
            if(num>0){
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                for(SelectionKey selectionKey:selectionKeys){
                    if(selectionKey.isConnectable()){
                        SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                        socketChannel.configureBlocking(false);
                        sk=socketChannel.register(selector,SelectionKey.OP_READ);
                        socketChannel.finishConnect();
                    }
                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
