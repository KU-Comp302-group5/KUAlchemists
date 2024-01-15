package domain.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import domain.Server;

public class HostHandler {
	
	private Server server;
	private String IPAddress;
	private int port;
	private ExecutorService pool;
	
	public void startServer() {
		server = new Server();
		IPAddress = server.getIPAdress();
		port = server.getPortNumber();
		
		pool = Executors.newCachedThreadPool();
		pool.execute(server);
	}

	public Server getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}
}
