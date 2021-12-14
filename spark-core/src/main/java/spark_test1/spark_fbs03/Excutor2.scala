package spark_test1.spark_fbs03

import java.io.ObjectInputStream
import java.net.ServerSocket

object Excutor2 {
  def main(args: Array[String]): Unit = {
    //todo 分布式测试多节点处理数据
    //启动服务器，接收数据
    val server = new ServerSocket(9999)
    println("server启动，等待接收数据...")

    //等待客户端的连接(如果没有连接，进程会处于阻塞状态)
    val client = server.accept()
    val in = client.getInputStream
    val objIn = new ObjectInputStream(in)

    //asInstanceOf：数据类型转换
    val subTask = objIn.readObject().asInstanceOf[WorkerTask]
    val ints = subTask.compute()

    println("计算节点[9999]计算结果为：" + ints)

    objIn.close()
    client.close()
    server.close()

  }

}
