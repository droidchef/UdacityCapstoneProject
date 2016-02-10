package in.ishankhanna.notifshredder.provider.installedapplication;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import in.ishankhanna.notifshredder.provider.base.AbstractSelection;

/**
 * Selection for the {@code installedapplication} table.
 */
public class InstalledapplicationSelection extends AbstractSelection<InstalledapplicationSelection> {
    @Override
    protected Uri baseUri() {
        return InstalledapplicationColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InstalledapplicationCursor} object, which is positioned before the first entry, or null.
     */
    public InstalledapplicationCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InstalledapplicationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public InstalledapplicationCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InstalledapplicationCursor} object, which is positioned before the first entry, or null.
     */
    public InstalledapplicationCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InstalledapplicationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public InstalledapplicationCursor query(Context context) {
        return query(context, null);
    }


    public InstalledapplicationSelection id(long... value) {
        addEquals("installedapplication." + InstalledapplicationColumns._ID, toObjectArray(value));
        return this;
    }

    public InstalledapplicationSelection idNot(long... value) {
        addNotEquals("installedapplication." + InstalledapplicationColumns._ID, toObjectArray(value));
        return this;
    }

    public InstalledapplicationSelection orderById(boolean desc) {
        orderBy("installedapplication." + InstalledapplicationColumns._ID, desc);
        return this;
    }

    public InstalledapplicationSelection orderById() {
        return orderById(false);
    }

    public InstalledapplicationSelection name(String... value) {
        addEquals(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection nameNot(String... value) {
        addNotEquals(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection nameLike(String... value) {
        addLike(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection nameContains(String... value) {
        addContains(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection nameStartsWith(String... value) {
        addStartsWith(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection nameEndsWith(String... value) {
        addEndsWith(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationSelection orderByName(boolean desc) {
        orderBy(InstalledapplicationColumns.NAME, desc);
        return this;
    }

    public InstalledapplicationSelection orderByName() {
        orderBy(InstalledapplicationColumns.NAME, false);
        return this;
    }

    public InstalledapplicationSelection packageName(String... value) {
        addEquals(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection packageNameNot(String... value) {
        addNotEquals(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection packageNameLike(String... value) {
        addLike(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection packageNameContains(String... value) {
        addContains(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection packageNameStartsWith(String... value) {
        addStartsWith(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection packageNameEndsWith(String... value) {
        addEndsWith(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationSelection orderByPackageName(boolean desc) {
        orderBy(InstalledapplicationColumns.PACKAGE_NAME, desc);
        return this;
    }

    public InstalledapplicationSelection orderByPackageName() {
        orderBy(InstalledapplicationColumns.PACKAGE_NAME, false);
        return this;
    }
}
