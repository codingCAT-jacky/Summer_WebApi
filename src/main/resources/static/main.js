$(document).ready(function(){
    $('button').click(function(){
        let $sightlist1 = $('#sightlist');
        let value = $(this).text();
        let Url ="http://localhost:8080/Search?keyword="+value;
        console.log(Url);
        $.ajax({
          url:Url,
          method:"GET",
          dataType:"json",
          success:function(returnSights){
          console.log("test1");
          $('#sightlist').html("");
          $.each(returnSights, function(index, sight){
          let mapURL = "https://www.google.com.tw/maps/place/" + sight.address;
          let card1 = `
            <div class="card">
              <div class="card-header">${sight.sightName}</div>
              <div class="card-body">
                  <p>
                  地區:${sight.zone}</br>
                  分類:${sight.category}
                  </p>
              </div>
              <a href=${mapURL}
                 target="_blank"
                 class="btn btn-primary">
              地址
              </a>
              </div>
            </div>
          `;

          let collapseURL = "#collapse" + index;
          let showcard2 = `<img src=${sight.photoURL} width="100" high="100"alt="此景點無圖片">
                                                   <div>${sight.description}</div>`;


          let card2 =
          `
                      <div class="card">
                        <div class="card-header">
                         <a class="btn" data-bs-toggle="collapse" href=${collapseURL}>
                         詳細資訊
                         </a>
                        </div>
                        <div class="card-body">
                            <div id="collapse${index}" class="collapse">
                            ${showcard2}
                            </div>
                        </div>
                      </div>
          `;


//          if(sight.photoURL=="")
//          {
//            card2.append(showcard1);
//          }
//          else
//          {
//            card2.append(showcard2);
//          }
          let finalcard = $("<div></div>").addClass("col-md-12 col-lg-4")
                                          .attr("id", "showcards");

          finalcard.append(card1, card2);
          $sightlist1.append(finalcard);
          })
          }
        });
    })
});