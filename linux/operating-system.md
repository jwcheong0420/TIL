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

## Kernel Module
### load할 kernel module을 변경하기
#### install된 kernel module의 경우(ex. 3.10.0-1062.9.1.el7 -> 3.10.0-957.el7 로 변경)
* uname 확인
````
[root@dev ~]# uname -a
Linux dev 3.10.0-1062.9.1.el7.x86_64 #1 SMP Fri Dec 6 15:49:49 UTC 2019 x86_64 x86_64 x86_64 GNU/Linux
````
* kernel module 설치 여부 확인
````
[root@dev ~]#  yum list installed --showduplicate kernel
Loaded plugins: fastestmirror, product-id, search-disabled-repos, subscription-manager
This system is not registered with an entitlement server. You can use subscription-manager to register.
Loading mirror speeds from cached hostfile
* epel: fedora.cs.nctu.edu.tw
Installed Packages
kernel.x86_64              3.10.0-957.el7                   @anaconda/7.6
kernel.x86_64              3.10.0-1062.9.1.el7              @updates/7Server
````
* grub에 entry가 있는지 확인
````
[root@dev ~]# cat /boot/grub2/grub.cfg | grep 957
menuentry 'Red Hat Enterprise Linux Server (3.10.0-1062.9.1.el7.x86_64) 7.6 (Maipo)' --class red --class gnu-linux --class gnu --class os --unrestricted $menuentry_id_option 'gnulinux-3.10.0-957.el7.x86_64-advanced-01880d3a-f3c3-4d10-b32d-b9b3e4f7a6cc' {
menuentry 'Red Hat Enterprise Linux Server (3.10.0-957.el7.x86_64) 7.6 (Maipo)' --class red --class gnu-linux --class gnu --class os --unrestricted $menuentry_id_option 'gnulinux-3.10.0-957.el7.x86_64-advanced-01880d3a-f3c3-4d10-b32d-b9b3e4f7a6cc' {
        linux16 /vmlinuz-3.10.0-957.el7.x86_64 root=/dev/mapper/rhel_g1--1-root ro crashkernel=auto rd.lvm.lv=rhel_g1-1/root rd.lvm.lv=rhel_g1-1/swap rhgb quiet LANG=en_US.UTF-8
        initrd16 /initramfs-3.10.0-957.el7.x86_64.img
````
* grubenv 변경
    * saved_entry를 3.10.0-1062.9.1.el7에서 3.10.0-957.el7로 변경
````
[root@dev ~]# vi /boot/grub2/grubenv
# GRUB Environment Block
saved_entry=Red Hat Enterprise Linux Server (3.10.0-957.el7.x86_64) 7.6 (Maipo)
#saved_entry=Red Hat Enterprise Linux Server (3.10.0-1062.9.1.el7.x86_64) 7.6 (Maipo)
##################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################################
````
* reboot
````
[root@dev ~]# reboot
````
* uname 확인
````
[root@dev ~]# uname -a
Linux dev 3.10.0-957.el7.x86_64 #1 SMP Thu Oct 4 20:48:51 UTC 2018 x86_64 x86_64 x86_64 GNU/Linux
````