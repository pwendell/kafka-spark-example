import org.apache.spark.streaming._
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.kafka.KafkaUtils


object Test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[4]").setAppName("Test")
    val ssc = new StreamingContext(conf, Seconds(1))
    val stream = KafkaUtils.createStream(ssc, "localhost:2181", "streaming", Map("test" -> 1))
    stream.print()
    ssc.start()
  }
}

// vim: set ts=4 sw=4 et:
