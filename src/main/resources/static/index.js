function toggleLiveBirths() {
    const priorPregnancies = document.querySelector('input[name="priorPregnancies"]:checked');
    const liveBirthsGroup = document.getElementById('liveBirthsGroup');
    const liveBirthsOptions = document.querySelectorAll('input[name="priorLiveBirths"]');

    if (priorPregnancies && priorPregnancies.value === "0") {
        liveBirthsGroup.style.display = "none";
        liveBirthsOptions.forEach(option => {
            option.checked = false;
        });
    } else {
        liveBirthsGroup.style.display = "block";
        liveBirthsOptions.forEach(option => {
            option.disabled = false;
        });

        if (priorPregnancies.value === "1") {
            liveBirthsOptions.forEach(option => {
                if (option.value === "2+") {
                    option.disabled = true;
                }
            });
        }
    }
}

function toggleReasonsForInfertility() {
    const reasonsGroup = document.getElementById('reasonsForInfertility');
    const reasonKnownCheckbox = document.getElementById('reasonKnownCheckbox');
    const checkboxes = reasonsGroup.querySelectorAll('input[type="checkbox"]');
    const isDisabled = !reasonKnownCheckbox.checked;

    reasonsGroup.style.opacity = isDisabled ? 0.6 : 1;
    checkboxes.forEach(checkbox => {
        checkbox.disabled = isDisabled;
    });
}

document.addEventListener("DOMContentLoaded", () => {
    toggleReasonsForInfertility();
    const liveBirthsGroup = document.getElementById('liveBirthsGroup');
    liveBirthsGroup.style.display = "none";
});

function calculate() {

    clearErrors();

    const form = document.getElementById('ivf-form');
    const formData = new FormData(form);
    const data = {};

    formData.forEach((value, key) => {
        const inputElement = form.querySelector(`[name="${key}"]`);
        if (inputElement.type === 'checkbox') {
            data[key] = inputElement.checked;
        } else {
            data[key] = value;
        }
    });

    const attemptedIVFCheckbox = form.querySelector('input[name="attemptedIVFPreviously"]');
    data.attemptedIVFPreviously = attemptedIVFCheckbox ? attemptedIVFCheckbox.checked : false;

    fetch('/api/ivf/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(async (response) => {
        if (!response.ok) {
            const errors = await response.json();
            displayErrors(errors);
            throw new Error('Validation error');
        }
        return response.json();
    })
    .then(result => {
        clearErrors();
        document.getElementById('result').innerText = `Estimated Success Rate: ${(result * 100).toFixed(2)}%`;
    })
    .catch(error => {
        alert(error.message);
    });
}

function clearErrors() {
    document.querySelectorAll('.error-message').forEach((el) => {
        el.innerText = ''; 
    });
}

function displayErrors(errors) {
    Object.entries(errors).forEach(([key, value]) => {
        const errorElement = document.getElementById(`${key}-error`);
        if (errorElement) {
            errorElement.innerText = value;
        }
    });
}

function clearErrors() {
    document.querySelectorAll('.error-message').forEach(el => {
        el.innerText = '';
    });
}
