var id = [];
var question = [];
var option1 = [];
var option2 = [];
var option3 = [];
var option4 = [];
var answer = [];

$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/Entertaiment",
    data: "data",
    dataType: "json",
    success: function (response) {
      response.forEach((element) => {
        id.push(element.id);
        question.push(element.question);
        option1.push(element.option1);
        option2.push(element.option2);
        option3.push(element.option3);
        option4.push(element.option4);
        answer.push(element.Answer);
      });
    },
    complete: function (response) {
        for(let i=0; i<id.length;i++){
            $("#mainArticle p").text(id[i]);
            $("#mainArticle #question").text(question[i]);
            $("#mainArticle #option1").text(option1[i]);
            $("#mainArticle #option2").text(option2[i]);
            $("#mainArticle #option3").text(option3[i]);
            $("#mainArticle #option4").text(option4[i]);
        }
    }

  });


});
