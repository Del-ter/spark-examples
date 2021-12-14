package spark_test1.spark_fbs03

class WorkerTask extends Serializable {
  //数据为空
  var datas:List[Int] = _

  //函数也为空
  var logic: (Int)=>Int = _

  //方法
  //方法
  def compute() = {
    datas.map(logic)
  }

}
