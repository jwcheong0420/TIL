# Linux Commands Cheatsheet

사용했던 Linux Command를 정리

### Section 1 : User Commands
* sed : text를 필터링하고 변형시키는 stream 에디터
```bash
sed -i '/asdf/d' test.sh    # delete the line which contains 'asdf' in 'test.sh'
```

* dd : file을 변환하고 복사
```bash
dd if=/dev/zero of=testimg bs=1M count=1024   # 1MB씩 1024번을 /dev/zero(read시 0x00(null)을 반환하는 특수파일)에서 읽어와 testimg에 복사함
```

### Section 8 : System Administration tools and Daemons
* mke2fs : ext2/ext3/ext4 filesystem을 생성
```bash
mkfs.ext4 testimg     # testimg device에 ext4 file system을 생성
```

* resize2fs : ext2/ext3/ext4 file system resizer
```bash
resize2fs testimg 2G    # testimg의 ext계열 filesystem을 2G로 resize
```

* mount : file system을 mount
   * AUFS mount : Advanced Union File System
  ```bash
  mount -t aufs -o br=/rw_layer=rw:/layer_1=ro+wh:/layer_2=ro+wh none /mount_dir   # /rw_layer 디렉토리를 rw branch로, /layer_1과 /layer_2 디렉토리는 ro branch로 만들어 (physical disk partition이 link되지 않은) /mount_dir에 aufs 방식으로 mount
  mounyt -o remount -o append=/layer_3=ro+wh /mount_dir    # 이미 mount되어있는 /mount_dir에 /layer_3 디렉토리를 ro branch로 append
  ```
   * bind mount : 특정 디렉토리를 다른 디렉토리에 mount
  ```bash
  mount --bind /original_dir /mounted_dir   # /original_dir 디렉토리를 /mounted_dir 디렉토리에 mount
  mount --rbind /original_dir /mounted_dir  # /original_dir 디렉토리를 recursive하게 /mounted_dir 디렉토리에 mount
  ```

---
## Examples
