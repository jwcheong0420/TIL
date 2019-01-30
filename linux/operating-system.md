# Operating System

## Resources
### CPU
* cpu 정보 확인
```bash
cat /proc/cpuinfo
```

* 전체 core 개수 확인
```bash
grep -c processor /proc/cpuinfo
```

* 물리 CPU 개수 확인
```bash
grep "physical id" /proc/cpuinfo | sort -u | wc -l
```

* CPU당 core 수 확인
```bash
grep "cpu cores" /proc/cpuinfo | tail -1
```

* hyperthreading 여부 확인
   * hyperthread가 켜져 있으면 (전체 core 개수) != (물리 CPU 개수) * (CPU당 core 수)일 수 있음... CPU의 thread 수가 core 수라고 봐도 무방할 듯
```bash
grep -o '^flags\b.*: .*\bht\b' /proc/cpuinfo | tail -1 | grep ht
```
