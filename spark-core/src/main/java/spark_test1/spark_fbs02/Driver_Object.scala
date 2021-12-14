package spark_test1.spark_fbs02

import java.io.ObjectOutputStream
import java.net.Socket

object Driver_Object {
  def main(args: Array[String]): Unit = {
    //todo 分布式测试对象输出流

    //连接服务器
    val client = new Socket("localhost", 9999)

    //输出数据流（传输对象）
    val out = client.getOutputStream
    val objOut = new ObjectOutputStream(out)

    objOut.writeObject(new Task)

    objOut.flush()
    objOut.close()

    println("数据发送完毕...")

    client.close()
  }

}
