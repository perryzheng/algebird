package com.twitter.algebird

import Array._

/**
 * @param dimensions: Number of dimensions
 * @param numHashFunctions: number of hash functions
 * @param numTuplesForEachHashFunction: tuples in each of the L hash functions
 * @param bucketSize: size of the bucket, defaults to 4
 */
case class RNearNeighbor (
  dimensions: Int,
  numHashFunctions: Int,
  numTuplesForEachHashFunction: Int,
  bucketSize: Int = 4) { 


}

/**
 * A point is defined as a vector of coordinates
 * @param index: the index of this point in the dataset list of points
 * @param coordinates: 
 */
case class Point(
  index: Int,
  coordinates: Seq[Double]
)

/** 
 * A function drawn from the locality-sensitive family of hash functions
 * @param a: the random vector in d dimensions
 * @param b: the random number drawn from [0, w]
 */
case class LSHFunction { 
  a: Seq[Double],
  b: Double
}

class LocalitySensitiveHashing(rNearNeighbor: RNearNeighbor) { 
  private val gaussianGenerator = GaussianDistribution(0, 1)
  private val r = new java.util.Random()

  private def genGaussianRandom() = 
    gaussianGenerator.sample(r)

  private def genUniformRandom(rangeMin: Double, rangeMax: Double) = 
    rangeMin + (rangeMax - rangeMin) * r.nextDouble();

  /**
   * returns a matrix of size numHashFunctions x numTuplesForEachHashFunction
   * nHFTuples = L
   * hfTuplesLength = K 
   * dimension
   */
  lazy val hashFunctions: Array[Array[LSHFunction]] = { 
    val lshFuntions = ofDim[LSHFunction](numHashFunctions,
      numTuplesForEachHashFunction)

    for (i <- 0 to rNearNeighbor.numHashFunctions) {
      for (j <- 0 to rNearNeighbor.numTuplesForEachHashFunction) {
        for (k <- 0 to rNearNeighbor.dimensions) { 
          lshFuntions(i)(j).a(k) = genGaussianRandom()    
        }

        lshFuntions(i)(j).b = genUniformRandom(0, rNearNeighbor.bucketSize)
      }
    }
    lshFuntions
  }

  def computeLSHValue(hashFunctionIndex: Int, point: Point) = { 
  }

  def addNewPointToRNearNeighborStruct(rNearNeighbor: RNearNeighbor, point: Point) = { 


  }
}