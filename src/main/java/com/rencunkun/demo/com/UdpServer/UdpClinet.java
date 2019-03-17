package com.rencunkun.demo.com.UdpServer;

import java.io.IOException;
import java.net.*;

//udp服务器
class UdapServer{
    public static void main(String[] args) throws IOException {
        //ip地址+端口号
        System.out.println("udp服务器已经启动");
        //创建服务器端口号  默认使用本机ip地址
        DatagramSocket ds=new DatagramSocket(8080);
;       //服务器接受客户端呢1024个字节
        byte [] bytes =new byte[1024];
        //定义数据包
        DatagramPacket dp =new DatagramPacket(bytes,bytes.length);
        //接受客户端请求，讲数据封装给数据包  如果客户端不往服务器发送请求，就一直堵塞
        ds.receive(dp);
        System.out.println("来源ip地址："+dp.getAddress()+dp.getPort());
        String result = new String(dp.getData(), 0, dp.getLength());
        System.out.println(result);
        ds.close();
    }
}

//先写服务器端 在写客户端
public class UdpClinet {
    public static void main(String[] args) throws IOException {
        System.out.println("udp客户端启动连接...");
        //不传入端口号 作用客户端  创建一个socket客户端
        DatagramSocket ds =new DatagramSocket();
        String  str="中国";
        byte[] strBytest=str.getBytes();
        DatagramPacket dp =new DatagramPacket(strBytest,strBytest.length, InetAddress.getByName("127.0.0.1"),8080);
        ds.send(dp);
        ds.close();
    }
}
