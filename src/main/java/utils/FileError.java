package utils;

import java.util.Arrays;
import java.util.List;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author GOBERT Guillaume
 *
 */
public class FileError extends ch.qos.logback.core.filter.AbstractMatcherFilter {

	@Override
	public FilterReply decide(Object event) {
		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}

		LoggingEvent loggingEvent = (LoggingEvent) event;

		List<Level> eventsToKeep = Arrays.asList(Level.WARN, Level.ERROR);
		if (eventsToKeep.contains(loggingEvent.getLevel())) {
			return FilterReply.NEUTRAL;
		} else {
			return FilterReply.DENY;
		}
	}

}
