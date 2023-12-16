document.addEventListener('DOMContentLoaded', function () {
    const editBtn = document.getElementById('editBtn');
    const saveBtn = document.getElementById('saveBtn');
    const editableFields = document.querySelectorAll('.editable-field');
  
    editBtn.addEventListener('click', function () {
      // Enable content editing
      editableFields.forEach(field => {
        field.contentEditable = true;
        field.style.border = '1px solid #4CAF50';
      });
  
      // Toggle button visibility
      editBtn.style.display = 'none';
      saveBtn.style.display = 'block';
    });
  
    saveBtn.addEventListener('click', function () {
      // Disable content editing
      editableFields.forEach(field => {
        field.contentEditable = false;
        field.style.border = '1px solid #ccc';
      });
  
      // Toggle button visibility
      editBtn.style.display = 'block';
      saveBtn.style.display = 'none';
    });
  });
  