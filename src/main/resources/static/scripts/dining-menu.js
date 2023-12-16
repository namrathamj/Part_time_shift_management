document.addEventListener('DOMContentLoaded', function () {
    const daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'];
    const meals = ['Breakfast', 'Lunch', 'Dinner'];

    // Actual food items for each meal and day
    const menuData = {
        Monday: {
            Breakfast: ['Scrambled Eggs', 'Bacon', 'Toast'],
            Lunch: ['Chicken Salad', 'Vegetable Soup', 'Fruit'],
            Dinner: ['Grilled Salmon', 'Quinoa', 'Steamed Vegetables'],
        },
        Tuesday: {
            Breakfast: ['Oatmeal', 'Yogurt', 'Berries'],
            Lunch: ['Turkey Sandwich', 'Tomato Soup', 'Chips'],
            Dinner: ['Pasta Bolognese', 'Garlic Bread', 'Caesar Salad'],
        },
        Wednesday: {
            Breakfast: ['Pancakes', 'Maple Syrup', 'Sausages'],
            Lunch: ['Vegetarian Wrap', 'Minestrone Soup', 'Coleslaw'],
            Dinner: ['Steak', 'Mashed Potatoes', 'Green Beans'],
        },
        Thursday: {
            Breakfast: ['Fruit Smoothie', 'Granola', 'Greek Yogurt'],
            Lunch: ['Caprese Salad', 'Pesto Pasta', 'Breadsticks'],
            Dinner: ['Shrimp Stir-Fry', 'Brown Rice', 'Asian Slaw'],
        },
        Friday: {
            Breakfast: ['Bagel with Cream Cheese', 'Smoked Salmon', 'Orange Juice'],
            Lunch: ['BLT Sandwich', 'Sweet Potato Fries', 'Cucumber Salad'],
            Dinner: ['Vegetable Curry', 'Basmati Rice', 'Naan Bread'],
        },
    };

    const menuTable = document.getElementById('menu-table');

    // Create the table header
    const headerRow = document.createElement('tr');
    headerRow.innerHTML = '<th>Day</th><th>Breakfast</th><th>Lunch</th><th>Dinner</th>';
    menuTable.appendChild(headerRow);
    headerRow.classList.add('menu-header');

    daysOfWeek.forEach(day => {
        const dayRow = document.createElement('tr');

        // Add the day name to the first column
        const dayCell = document.createElement('td');
        dayCell.classList.add('week-day');
        dayCell.textContent = day;
        dayRow.appendChild(dayCell);

        meals.forEach(meal => {
            const mealDiv = document.createElement('div');
            mealDiv.classList.add('meal-card');

            const mealHeading = document.createElement('h3');
            mealHeading.textContent = meal;

            mealDiv.appendChild(mealHeading);

            // Use actual food items from the menuData object
            const foodItems = menuData[day][meal];
            foodItems.forEach(foodItem => {
                const foodItemElement = document.createElement('p');
                foodItemElement.textContent = foodItem;

                mealDiv.appendChild(foodItemElement);
            });

            const cell = document.createElement('td');
            cell.appendChild(mealDiv);
            dayRow.appendChild(cell);

            // Add animation using anime.js
            anime({
                targets: mealDiv,
                translateY: [50, 0],
                opacity: [0, 1],
                duration: 800,
                easing: 'easeOutQuad',
                delay: anime.stagger(100),
            });
        });

        menuTable.appendChild(dayRow);
    });
});
