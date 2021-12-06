// 11-2_6heehan
// 한 준 희

package assignment.week4;

public class Pager {
    // 전체 게시글 수
    long totalCount;
    
    //현재 페이지 
    long pageIndex;

    //페이지네비게이션에서 보여주는 블럭 수
    long blockCount;

    //전체 페이지 블럭 수
    long totalBlockCount;

    public Pager(long totalCount, long pageIndex, long blockCount) {
        this.totalCount = totalCount;
        this.pageIndex = pageIndex;
        this.blockCount = blockCount;

        long tempCount = totalCount / blockCount;
        if(totalCount != tempCount * blockCount) tempCount += 1;
        this.totalBlockCount = tempCount;
    }

    public String html(long pageIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href='#'>[처음]</a>\n")
            .append("<a href='#'>[이전]</a>\n\n");
        
        long temp = pageIndex / blockCount * blockCount + 1;
        //현재 index에가 시작하는 block 
        long blockPage = (pageIndex / blockCount + 1) * blockCount;
        //현재 page에서 보여줘야할 index 범위 계산

        for(long i=temp;i<=blockPage;i++) {
            if(i > totalBlockCount) break;
            // 총 page보다 큰 경우 출력하지 않고 종료
            if(i == pageIndex) {
                sb.append("<a href='#' class='on' style='color:red'>"+i+"</a>\n");
                //현재 페이지의 경우 
            }
            else {
                sb.append("<a href='#'>"+i+"</a>\n");
                //현재 페이지가 아닌 경우
            }
        }
        
        sb.append("\n<a href='#'>[다음]</a>\n")
            .append("<a href='#'>[마지막]</a>\n");
        
        return sb.toString();
    }
}
