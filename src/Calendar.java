import java.util.TimeZone;

public class Calendar {

	static final String[][] MONTH_NAMES_ENGLISH_GERMAN = new String[][] {
			{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" },
			{ "Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" },
			{ "jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc" },
			{ "jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez" },
			{ "jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec" },
			{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" },
			{ "ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic" } };

	static final String[] DAYS_OF_THE_WEEK = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

	static java.util.Calendar Calendar_calendar;

	static int js5Port;

	static Font fontPlain11;

	static {
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}

	public static class208 method1780() {
		return Client.keyHandlerInstance;
	}
}
