(function() {
  const form = document.querySelector('form[action="/register"]');
  if (!form) return;

  const passwordInput = form.querySelector('input[name="password"]');
  const confirmInput = document.getElementById('confirmPassword');
  const errorBox = document.getElementById('registerError');

  function showError(message) {
    if (!errorBox) return;
    errorBox.textContent = message;
    errorBox.style.display = 'block';
  }

  function clearError() {
    if (!errorBox) return;
    errorBox.textContent = '';
    errorBox.style.display = 'none';
  }

  form.addEventListener('submit', function(e) {
    clearError();
    const pwd = passwordInput ? passwordInput.value : '';
    const cpwd = confirmInput ? confirmInput.value : '';

    if (pwd.length < 6) {
      e.preventDefault();
      showError('The password must be at least 6 characters long.');
      return;
    }

    if (pwd !== cpwd) {
      e.preventDefault();
      showError('Passwords don\'t match');
      return;
    }
  });
})();
