package co.com.apims.utils;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class LocalTestServerContext implements AutoCloseable {

	private final MockWebServer server;
		

	public LocalTestServerContext(String responseBody) throws IOException {
		this.server = new MockWebServer();			
		MockResponse response = new MockResponse();
		response.setHeader("Content-Type", "application/json");
		response.setBody(responseBody);
		server.enqueue(response);
		server.start();
	}

	@Override
	public void close() throws Exception {
		try {
			server.shutdown();
		} catch (IOException e) {
			System.err.println("Failed to close server: " + e);
		}
	}

}
