package scalaOverview

class DateTest(y: Int, m: Int, d: Int) extends Ord {
  def year = y

  def month = m

  def day = d

  override def toString(): String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean = that.isInstanceOf[DateTest] && {
    val o = that.asInstanceOf[DateTest]
    o.day == day && o.month == month && o.year == year
  }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[DateTest])
      sys.error("cannot compare " + that + " and a Date")

    val o = that.asInstanceOf[DateTest]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        (month == o.month && day < o.day)))
  }
}