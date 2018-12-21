# Linux File Hierarchy Structure
알게 된 Linux File(혹은 Directory) 구조 정리

### /etc
host와 관련된 system configuration을 갖고 있는 디렉토리
* /etc/fstab : Linux booting할 때 mount할 정보가 담긴 파일
```bash
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
# / was on /dev/sda2 during installation
UUID=0b467d44-4533-4031-9125-2b22747dab7c /               ext4    errors=remount-ro 0       1
# /boot/efi was on /dev/sda1 during installation
UUID=ED4A-A405  /boot/efi       vfat    umask=0077      0       1
/swapfile                                 none            swap    sw              0       0
```




---
* 참고 사이트
   * http://webdir.tistory.com/101
   * https://www.geeksforgeeks.org/linux-file-hierarchy-structure/
   * http://coffeenix.net/doc/kuls/file_system-4.html
   * http://jikime.tistory.com/448
