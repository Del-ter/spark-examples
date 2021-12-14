package spark_test1.spark_fbs01

import java.net.ServerSocket

object Excutor {
  def main(args: Array[String]): Unit = {
    //todo socket网络编程思想
    //启动服务器，接收数据
    val server = new ServerSocket(9999)
    println("server启动，等待接收数据...")

    //等待客户端的连接(如果没有连接，进程会处于阻塞状态)
    val client = server.accept()
    val in = client.getInputStream

    val data = in.read()
    println("接收到数据：" + data)

    in.close()
    client.close()
    server.close()

  }

}
