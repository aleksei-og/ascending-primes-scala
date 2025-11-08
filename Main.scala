@main def ascendingPrimes(): Unit = {
  val ascendingNumbers = generateAscendingNumbers()
  val primes = ascendingNumbers.filter(isPrime)
  println(s"Found ${primes.size} ascending primes:")
  println(primes.mkString(", "))
}

// Генерирует числа с возрастающими десятичными цифрами (1-9, без повторений)
def generateAscendingNumbers(): Seq[Int] = {
  (1 to 9).flatMap(n => combinationsOfDigits(n))
          .map(_.mkString.toInt)
}

// Получает все возрастающие комбинации цифр длины n
def combinationsOfDigits(n: Int): Seq[Seq[Int]] = {
  (1 to 9).toList.combinations(n).toList
}

// Простая проверка на простоту
def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else if (n == 2) true
  else if (n % 2 == 0) false
  else !(3 to math.sqrt(n).toInt by 2).exists(n % _ == 0)
}

