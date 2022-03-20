$('#btn-save').on('click',function (){
    var jsonData = JSON.stringify({
        content: $('#content').val()
    });
    $.ajax({
        type: "POST",
        url: '/api/board/',
        dataType: 'text',
        contentType: 'application/json; charset=utf-8',
        data: jsonData
    }).done(function(){
        window.location.href='/board';
    }).fail(function (error){
        alert(JSON.stringify(error));
    })
})
$('.btn-danger').on('click',function (){
    $.ajax({
        type: "DELETE",
        url: `/api/board/${$(this).val()}`,
        dataType: 'text'
    }).done(function(){
        window.location.href='/board';
    }).fail(function (error){
        alert(JSON.stringify(error));
    })
})
$('.form-check-input').click(function (){
    var jsonData = JSON.stringify({
        id: $(this).val()
    });
    $.ajax({
        type: "PUT",
        url: `/api/board/checked/${$(this).val()}`,
        dataType: 'text',
        contentType: 'application/json; charset=utf-8',
        data: jsonData
    }).done(function (){
        window.location.href='/board';
    }).fail(function (error){
        alert(JSON.stringify(error));
    })
})