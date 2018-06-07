package Suporte;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class Generator {
	public static String dataHora() {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
		
	}

}
