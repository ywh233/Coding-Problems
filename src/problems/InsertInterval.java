package problems;

import model.Interval;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Edwin on 15/10/5.
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // find overlaps
        Iterator<Interval> iter = intervals.iterator();
        while (iter.hasNext()) {
            Interval interval = iter.next();
            Interval merged = tryMerge(interval, newInterval);
            if (merged != null) {
                iter.remove();
                newInterval = merged;
            }
        }

        intervals.add(newInterval);
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        return intervals;
    }

    private static Interval tryMerge(Interval i1, Interval i2) {
        if ((i1.start < i2.start && i1.end < i2.start) || (i2.start < i1.start && i2.end < i1.start)) {
            return null;
        }

        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}
