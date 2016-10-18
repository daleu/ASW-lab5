package twitter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {

		//final Twitter twitter = new TwitterFactory().getInstance();

		/*
		 * Date now = new Date(); String latestStatus =
		 * "I want to increase the Klout score of @cfarre [task #4 completed " +
		 * now + "]"; Status status = twitter.updateStatus(latestStatus);
		 * System.out.println("Successfully updated the status to: " +
		 * status.getText());
		 */

		// Status status = twitter.getUserTimeline("@fib_was").get(0);
		//
		// System.out.println(status.getText());
		//
		// twitter.retweetStatus(status.getId());

		StatusListener listener = new StatusListener() {

			public void onStatus(Status status) {
				System.out.println(status.getUser().getName() + " (@" + status.getUser().getScreenName() + "): "
						+ status.getText());
			}

			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}
		};

		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.addListener(listener);
		twitterStream.filter("#barcelona");
	}
}
