package spark_test1.spark_fbs02

//网络传输必须序列化
class Task extends Serializable {

  //数据
  private val datas = List(1, 2, 3, 4, 5)

//  val logic = (num:Int)=>{num*2}
  //指定该对象为一个函数
  val logic: (Int)=>Int = _*2

  //方法
  def compute() = {
    datas.map(logic)
  }

}
