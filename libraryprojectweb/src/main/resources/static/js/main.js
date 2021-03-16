const linkColor = document.querySelectorAll('.nav__link')
const btn = document.querySelector('.book-btn')
const arrow = document.querySelector('.sidebar-menu ul .first')
const submenu = document.querySelector('.sidebar-menu ul .book-show')

function colorLink() {
    if (linkColor) {
        linkColor.forEach(l => l.classList.remove('active'))
        this.classList.add('active')
    }
}
linkColor.forEach(l => l.addEventListener('click', colorLink))

btn.addEventListener('click', function() {
    submenu.classList.toggle('show')
    arrow.classList.toggle('rotate')
});

$(function () {
    $(".mul-select").select2({
      placeholder: " select Sub Category",
      tags: true,
      tokenSeparators: ["/", ",", ";", " "],
    });
  });