## Unix 철학(Unix Philosophy)

Docker와 Podman을 비교하며 조사하던 중, *Docker는 하나의 큰 daemon이 제어를 하기 때문에, single point of failure로 작용할 수 있으며 Unix 철학에 맞지도 않다*는 내용을 심심치 않게 볼 수 있었다. Daemon이 죽으면 critical한 건 그렇다치는데, Unix 철학이 뭐길래 Docker의 단점으로 언급되는지 궁금해서 찾아보게 되었다.

### Unix Philosophy란
켄 톰슨(Ken Thompson)이 개발한 UNIX와, 그 후손들(Linux, BSD 등)의 핵심이 되는 철학

### Origin
켄 톰슨이 UNIX를 개발할 때 고안했다고는 하지만 딱히 문서화된 건 아니다. 더글라스 맥클로이(Douglas Mcllroy)가 최초로 문서화했다<sup id="a1">[1](#f1)</sup>.

    1. 각 프로그램이 한 가지 일을 잘하게 만들어라. 새로운 작업을 할 때, 오래된 프로그램에 새로운 기능을 추가해서 복잡하게 만들지 말고 새로운 프로그램을 만들어라.
    2. 모든 프로그램의 output이 아직 알려지지 않은 프로그램의 input이 될 것을 고려해라. 관련 없는 정보로 output을 채우지 말아라. 까다롭게 세로로 구분되거나 바이너리로 된 input 형식은 피하라. 대화식 input을 고집하지 말아라.
    3. 소프트웨어(운영체제일 지라도)를 빨리(이상적으로는 몇 주 안에) 시도하면서 설계하고 만들어라. 서투른 부분을 버리고 다시 build하는 것을 망설이지 말아라.
    4. 프로그래밍 작업을 가볍게하기 위해서(우회해야하고 tool을 다 쓴 뒤 버려야할 지라도) 미숙한 수작업보단 tool을 사용해라.
참... 길다. 이후에 피터 사루스(Peter H. Salus)가 이렇게 요약했다고 한다<sup id="a2">[2](#f2)</sup>.

    1. 한 가지 일만 잘 하는 프로그램을 만들어라.
    2. 다른 프로그램과 함께 동작할 수 있는 프로그램을 만들어라.
    3. 텍스트 스트림을 처리할 수 있는 프로그램을 만들어라. 텍스트 스트림이 가장 범용적인 인터페이스이기 때문이다.

### Do One Thing and Do It Well
그러니까 Unix 철학의 핵심 내용은 한 줄로 표현하면 **Do One Thing and Do It Well**인 셈이다.

이렇게 프로그램은 각자 맡은 일만 잘 하고, 각 프로그램의 입출력을 엮어서 원하는 기능을 만들면 된다. Unix-like OS에서 작업하다보면 여러 command를 pipe(|)로 연결해서 사용할 때가 많은데, 이것이야말로 Unix 철학이 아주 쉽게 와닿는 예시가 되겠다. 참고로 이 Unix Pipe도 더글라스 맥클로이 작품.

### Footnotes
* <b id="f1">1</b> [Douglas Mcllroy, The Bell System Technical Journal 1978](https://web.archive.org/web/20100715152821/http://www.faqs.org/docs/artu/ch01s06.html) [↩](#a1)
* <b id="f2">2</b> [Peter H. Salus, A Quarter-Century of Unix 1994](https://web.archive.org/web/20100715152821/http://www.faqs.org/docs/artu/ch01s06.html) [↩](#a2)

### References
* https://en.wikipedia.org/wiki/Unix_philosophy
* https://joone.net/2017/05/20/9-%EC%9C%A0%EB%8B%89%EC%8A%A4-%EC%B2%A0%ED%95%99-2/
* https://johngrib.github.io/wiki/Unix-philosophy/
* http://www.linfo.org/unix_philosophy.html
    * https://shoark7.github.io/programming/knowledge/unix-philosophy-intro
* https://en.wikipedia.org/wiki/Pipeline_(Unix)
