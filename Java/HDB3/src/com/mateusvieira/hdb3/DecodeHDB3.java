package com.mateusvieira.hdb3;

public class DecodeHDB3 {

    public static String decode(String data) {

	String message = data;

	char lastpo1 = '0';
	char tempc = '0';

	for (int pos = 0; pos < message.length(); pos++) {
	    if (message.charAt(pos) != '0') {
		tempc = message.charAt(pos);

		if (lastpo1 == message.charAt(pos)) {
		    message = message.substring(0, pos - 3) + "0000" + message.substring(pos + 1);
		}
		lastpo1 = tempc;
	    }
	}

	for (int pos = 0; pos < message.length(); pos++) {
	    if (message.charAt(pos) != '0') {
		message = message.substring(0, pos) + '1' + message.substring(pos + 1);
	    }
	}
	return message;
    }
}
