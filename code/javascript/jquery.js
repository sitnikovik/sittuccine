$(document).ready(function() {
    // Selectors
    var $button = $("#myButton");
    var $paragraphs = $("p");

    // Event Handlers
    $button.on("click", function() {
        alert("Button clicked!");
    });

    // CSS Manipulation
    $paragraphs.css("color", "blue");

    // DOM Manipulation
    $paragraphs.each(function(index, element) {
        $(element).text("Paragraph " + (index + 1));
    });

    // AJAX Request
    $.ajax({
        url: "https://api.example.com/data",
        method: "GET",
        success: function(data) {
            console.log(data);
        },
        error: function(error) {
            console.error(error);
        }
    });
});