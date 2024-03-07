package Task5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MixStream {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zipIterator = new Iterator<T>() {
            private boolean switcher = true;

            @Override
            public boolean hasNext() {
                return switcher ? firstIterator.hasNext() : secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                switcher = !switcher;
                return switcher ? secondIterator.next() : firstIterator.next();
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(zipIterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

}
