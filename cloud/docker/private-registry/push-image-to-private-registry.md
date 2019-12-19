# Docker private registry에 image push하기 #

## private registry 등록하기 ##
### docker 설정 추가 ###
/etc/docker/daemon.json에 아래의 내용을 추가
<pre>
    <code>
    vi /etc/docker/daemon.json
    { "insecure-registries":["192.168.122.57:5000"] }
    </code>
</pre>

### docker 설정 적용하기 ###
<pre>
    <code>
    systemctl restart docker
    </code>
</pre>


## 이미지 준비 ##
### 원하는 이미지를 docker hub에서 받아오기 ###
docker pull {name}:{tag}
<pre>
    <code>
    docker pull nvidia/k8s-device-plugin:1.0.0-beta4
    </code>
</pre>

### tar로 존재하던 이미지를 load하기 ###
docker load -i {tar file name}
<pre>
    <code>
    docker load -i k8s-device-plugin.tar
    </code>
</pre>

## 이미지 push ##
### image 이름을 변경하기 ###
docker tag {name}:{tag} {private registry ip}:{port}/{name}:{tag}
<pre>
    <code>
    docker tag nvidia/k8s-device-plugin:1.0.0-beta4 192.168.122.57:5000/k8s-device-plugin:1.0.0-beta4
    </code>
</pre>

### image 업로드하기 ###
docker push {바꾼 이미지 이름}
<pre>
    <code>
    docker push 192.168.122.57:5000/k8s-device-plugin:1.0.0-beta4
    </code>
</pre>

## 결과 확인 ##
### registry에서 이미지 리스트 확인하기 ###
<pre>
    <code>
    curl -X GET 172.21.3.6:5000/v2/_catalog
    </code>
</pre>

### registry에서 이미지 tag 확인하기 ###
<pre>
    <code>
    curl -X GET 172.21.3.6:5000/v2/k8s-device-plugin/tags/list
    </code>
</pre>