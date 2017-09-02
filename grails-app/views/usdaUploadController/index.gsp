Upload a file

Download a zip file from https://www.ars.usda.gov/northeast-area/beltsville-md/beltsville-human-nutrition-research-center/nutrient-data-laboratory/


<form action="/admin/usdaupload/save" method="post" >
    <fieldset class="form">
        <div class='fieldcontain required'>
            <label for='name'>Name<span class='required-indicator'>*</span></label>
            <input type="text" name="name" value="" required="" id="name" />
        </div>
        <div class='fieldcontain required'>
            <label for='game'>Game<span class='required-indicator'>*</span></label>
            <input type="text" name="game" value="" required="" id="game" />
        </div>
        <div class='fieldcontain'>
            <label for='region'>Region</label>
            <input type="text" name="region" value="" id="region" />
        </div>
        <div class='fieldcontain required'>
            <label for='wins'>Wins<span class='required-indicator'>*</span></label>
            <input type="number" name="wins" value="0" required="" min="0" id="wins" />
        </div>
        <div class='fieldcontain required'>
            <label for='losses'>Losses<span class='required-indicator'>*</span></label>
            <input type="number" name="losses" value="0" required="" min="0" id="losses" />
        </div>
    </fieldset>
    <fieldset class="buttons">
        <input type="submit" name="create" class="save" value="Create" id="create" />
    </fieldset>
</form>