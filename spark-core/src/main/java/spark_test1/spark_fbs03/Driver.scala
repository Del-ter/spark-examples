package spark_test1.spark_fbs03

import java.io.ObjectOutputStream
import java.net.Socket

object Driver {
  def main(args: Array[String]): Unit = {
    //todo 分布式测试对象输出流

    //连接服务器
    val client1 = new Socket("localhost", 8888)
    val client2 = new Socket("localhost", 9999)

    //主task
    val mainTask = new DataTask

    //给服务器1派发任务
    val out1 = client1.getOutputStream
    val objOut1 = new ObjectOutputStream(out1)
    val task1 = new WorkerTask
    task1.datas=mainTask.datas.take(2)
    task1.logic=mainTask.logic
    objOut1.writeObject(task1)
    objOut1.flush()
    objOut1.close()
    println("服务器1任务派发完毕...")
    client1.close()

    //给服务器2派发任务
    val out2 = client2.getOutputStream
    val objOut2 = new ObjectOutputStream(out2)
    val task2 = new WorkerTask
    task2.datas=mainTask.datas.takeRight(3)
    task2.logic=mainTask.logic
    objOut2.writeObject(task2)
    objOut2.flush()
    objOut2.close()
    println("服务器2任务派发完毕...")
    client2.close()

    println("所有数据发送完毕...")

  }

}
