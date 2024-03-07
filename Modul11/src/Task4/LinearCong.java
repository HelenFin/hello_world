package Task4;

import java.util.stream.Stream;

    public class LinearCong {

        public static Stream<Long> linearCongruentialGenerator(long a, long c, long m, long seed) {
            return Stream.iterate(seed, x -> (a * x + c) % m);
        }

        public static void main(String[] args) {
            long a = 25214903917L;
            long c = 11;
            long m = (long) Math.pow(2, 48);


            Stream<Long> randomNumberStream = linearCongruentialGenerator(a, c, m, System.currentTimeMillis());


            randomNumberStream.limit(10).forEach(System.out::println);
        }
    }

