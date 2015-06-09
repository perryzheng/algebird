package com.twitter.algebird.lsh.vector

import com.twitter.algebird.CheckProperties
import org.scalacheck.{ Arbitrary, Gen }
import org.scalatest._

class LshVectorMonoidTests extends CheckProperties {
  import com.twitter.algebird.BaseProperties._

  implicit val lshVectorGenerators = Arbitrary {
    for (
      array <- Gen.containerOf[Array, Double](Gen.choose(0, 10000))
    ) yield (LshVector(array))
  }

  implicit val arrayGenerators = Arbitrary {
    for (
      array <- Gen.containerOf[Array, Double](Gen.choose(0, 10000))
    ) yield (array)
  }

  // property("LshVectorMonoid is a Monoid") {
  //   monoidLawsEq[LshVector] { (left, right) =>
  //     println("left: " + left + "; right: " + right)
  //     left.size == right.size && left.toDoubleVec == right.toDoubleVec
  //   }
  // }
}