
function copierTexte(id) {
    const zone = document.getElementById(id);

    if (!zone) {
        alert("Zone de texte introuvable.");
        return;
    }

    const texte = zone.value;

    if (!texte) {
        alert("Il n'y a aucun texte à copier.");
        return;
    }

    if (navigator.clipboard && window.isSecureContext) {
        navigator.clipboard.writeText(texte)
            .then(() => alert("Texte copié !"))
            .catch(() => copierAvecSelection(zone));
    } else {
        copierAvecSelection(zone);
    }
}

function copierAvecSelection(zone) {
    zone.focus();
    zone.select();

    try {
        const reussi = document.execCommand("copy");
        alert(reussi ? "Texte copié !" : "Copiez le texte manuellement.");
    } catch (erreur) {
        alert("Copiez le texte manuellement.");
    }

    zone.setSelectionRange(0, 0);
}
