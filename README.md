RMI(Remote Method Invocation)服务端，采用lipermi-0.4包
定义公共接口Compute，也可以将接口定义为通用客户与服务端都引用即可。
1.这里定义了一个Compute接口，并实现他ComputeImpl。
2.申请CallHandler对象
3.多态产生ComputeImpl实例，指向Compute引用
4.用CallHandler对象注册Compute引用
5.申请Server对象
6.绑定端口与CallHandler对象
即完成服务端的远程方法，供客户端调用。示例代码如下


       CallHandler callHandler = new CallHandler();
		Compute remoteObject = new ComputeImp();
		callHandler.registerGlobal(Compute.class, remoteObject);

		Server server = new Server();
		int thePortIWantToBind = 6666;
		server.bind(thePortIWantToBind, callHandler);
		System.out.println("serve bind success");