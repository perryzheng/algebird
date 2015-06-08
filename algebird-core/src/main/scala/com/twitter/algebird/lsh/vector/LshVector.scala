package com.twitter.algebird.lsh.vector

import com.twitter.algebird.Monoid

/**
 * DoubleLshVector is just a thin wrapper around an Array of Doubles. It's pretty much the most
 * basic LshVector possible.
 * @param vector - The Array of Doubles to wrap.
 */
case class LshVector(vector: Array[Double]) extends BaseLshVector {
  def size = vector.size
  def apply(index: Int) = vector(index)
  def toDoubleVec = vector
}

object LshVector {
  implicit val lshVectorMonoid = LshVectorMonoid
}

object LshVectorMonoid extends Monoid[LshVector] {
  val saMonoid = new SummingArrayMonoid[Double]()

  override def zero = LshVector(saMonoid.zero)

  override def plus(left: LshVector, right: LshVector) =
    LshVector(saMonoid.plus(left.vector, right.vector))
}