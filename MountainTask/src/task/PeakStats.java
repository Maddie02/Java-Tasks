package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Provides basic statistics on the peaks dataset.
 */
public class PeakStats {
    // Contains in-memory the data from the dataset
    private final List<Peak> peaks;

    public PeakStats(InputStream dataInput) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(dataInput))
        ) {
            peaks = reader.lines()
                    .map(Peak::createPeak)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new IllegalArgumentException("Could not load dataset", exception);
        }
    }


    public PeakStats(String datasetPath) {
        throw new UnsupportedOperationException("Please provide implementation");
    }

    public List<Peak> getPeaks() {
        return Collections.unmodifiableList(peaks);
    }

    /**
     * @return - the height of the shortest peak that has never been ascended
     */
    public double shortestNotAscended() {
        return peaks.stream()
                .filter(peak -> peak.getFirstAscent() == 0)
                .min(Comparator.comparingDouble(Peak::getHeight))
                .get()
                .getHeight();
    }

    /**
     * How many times in average was a peak in Top N ascended. For example,
     * avgAscentsTopN(10) should return the average number of times a peak from the
     * highest 10 has been ascended.
     *
     * @return - the first n peaks to include in the statistics
     */
    public double avgAscentsTopN(int n) {
        return peaks.stream()
                .sorted(Comparator.comparingInt(Peak::getPos))
                .limit(n)
                .collect(Collectors.averagingInt(Peak::getTotalAscents));
//                .mapToInt(Peak::getTotalAscents)
//                .average()
//                .getAsDouble();
    }

    /**
     * If there are peaks with equal prominence, we consider the supplied one as
     * higher
     *
     * @param prominence-
     *            the prominence in meters
     * @return the position where a peak with the given prominence would rank.
     */
    public long getPositionByProminence(double prominence) {
        return peaks.stream()
                .sorted(Comparator.comparingDouble(Peak::getProminence).reversed())
                .takeWhile(peak -> peak.getProminence() != prominence)
                .count() + 1;
    }

    /**
     * @param year
     *            - year of ascent
     * @return - the highest peak ascended in the given year.
     * @throws -
     *             {@link IllegalArgumentException}, if there are no peaks ascended
     *             in the given year.
     */
    public Peak getHighestAscentPerYear(int year) {
        return peaks.stream()
                .filter(peak -> peak.getFirstAscent() == year)
                .max(Comparator.comparingDouble(Peak::getHeight))
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @return - the list of peaks that are not part of the Himalaya.
     */
    public List<String> getNonHimalayaNamesByProminence() {
        return peaks.stream()
                .filter(peak -> !(peak.getRange().contains("Himalaya")))
                .sorted(Comparator.comparingDouble(Peak::getProminence).reversed())
                .map(Peak::getName)
                .collect(Collectors.toList());
    }

    /**
     * Returns the name of the mountain range that has the most peaks in Top N
     */
    public String getRangeWithMostPeaks(int n) {
        return peaks.stream()
                .sorted(Comparator.comparingDouble(Peak::getPos))
                .limit(n)
                .collect(Collectors.groupingBy(Peak::getRange, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
    }

    /**
     * Returns the names of the peaks in the given from-to interval according to
     * their height ranking with "\n" as separator
     */
    public String listPeaks(int from, int to) {
        throw new UnsupportedOperationException("Please provide implementation");
    }
}
