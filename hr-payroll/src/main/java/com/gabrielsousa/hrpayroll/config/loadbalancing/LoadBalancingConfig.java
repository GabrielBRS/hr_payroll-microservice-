package com.gabrielsousa.hrpayroll.config.loadbalancing;

public class LoadBalancingConfig {
//
//	@Bean
//	@Primary
//	ServiceInstanceListSupplier serviceInstanceListSupplier() {
//		return new DemoServiceInstanceListSuppler("hr-worker");
//	}
//
//}
//
//class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {
//
//	private final String serviceId;
//
//	DemoServiceInstanceListSuppler(String serviceId) {
//		this.serviceId = serviceId;
//	}
//
//	@Override
//	public String getServiceId() {
//		return serviceId;
//	}
//
//	@Override
//	public Flux<List<ServiceInstance>> get() {
//		return Flux.just(Arrays.asList(
//				new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8001, false),
//				new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8002, false),
//				new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 8002, false)));
//	}
}
