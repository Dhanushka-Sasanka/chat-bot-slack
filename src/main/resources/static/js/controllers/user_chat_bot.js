


function chatSendBtnAction() {
    console.log("hello");
    let dataObj =  {
        text: $("#chat_box_text").val(),
            type: "developer"
    };
    $.ajax({
        type: "POST",
        url: baseURLAPI + 'chat-bot',

        contentType : "application/json",

        data : JSON.stringify(dataObj),
        cache: false,
        timeout: 600000,
        success: function (data) {
            if (data == 1) {
                swal({
                    title: "Success...!",
                    text: "your Account has been created..!",
                    icon: "success",

                });
            } else if (data == 10) {
                swal({
                    title: "Unsuccessful...!",
                    text: "Please check password again..!",
                    icon: "error",
                });
            } else {
                swal({
                    title: "Have to integrate response ...!",
                    text: "Something wrong check again..!",
                    icon: "error",
                });
            }

        }
    });
}


$('#chat_bot_send_button').click(function () {
   chatSendBtnAction();
});
