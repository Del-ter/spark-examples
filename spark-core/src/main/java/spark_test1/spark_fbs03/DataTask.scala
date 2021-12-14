package spark_test1.spark_fbs03

//网络传输必须序列化
class DataTask extends Serializable {

  //数据
  val datas = List(1, 2, 3, 4, 5)

  //定义函数
  val logic: (Int)=>Int = _*2


}
