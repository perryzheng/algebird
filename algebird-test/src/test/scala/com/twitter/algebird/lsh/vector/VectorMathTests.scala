package com.twitter.algebird.lsh.vector

import org.specs.Specification
import org.specs.mock.Mockito

class VectorMathTests extends CheckProperties {
  import com.twitter.algebird.BaseProperties._

  property("Vector Math handle vectors correctly") {
    VectorMath.dot(Array(1.0), Array(1.0)) should be(1.0)
  }
}
