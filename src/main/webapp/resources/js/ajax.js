$(document).ready(function () {
    $('#addBook').click(function () {
        var bookName = $('#bookName').val();
        var bookDescription = $('#bookDescription').val();
        var firstPublished = $('#firstPublished').val();
        $.ajax({
            type: 'POST',
            data: {
                bookName: bookName,
                bookDescription: bookDescription,
                firstPublished: firstPublished,
                genres: []
            },
            url: '/admin/book',
            success: function (response) {
                $('#bookRow').append(response);
            }
        });
    });
});
