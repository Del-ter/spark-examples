package spark_test1.spark_fbs01

import java.net.Socket

object Driver {
  def main(args: Array[String]): Unit = {
    //todo 分布式尝试搭建
    //连接服务器
    val client = new Socket("localhost", 9999)
    //输出数据流
    val out = client.getOutputStream

    out.write(2)
    out.flush()
    out.close()

    client.close()
  }

}
