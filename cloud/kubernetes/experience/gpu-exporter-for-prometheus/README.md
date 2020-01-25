### Monitoring GPU using Prometheus on Kubernetes

* 구성

* 테스트한 환경
  * Kubernetes 1.16.3
  * 총 5대 node 중 GPU node 1대
    * GPU : nvidia Tesla P40
    * driver : nvidia driver 430.50

* 참고 자료
  * [nvidia dcgm exporter](https://github.com/NVIDIA/gpu-monitoring-tools/tree/master/exporters/prometheus-dcgm/k8s/pod-gpu-metrics-exporter#pod-gpu-metrics-exporter)

* Troubleshooting

