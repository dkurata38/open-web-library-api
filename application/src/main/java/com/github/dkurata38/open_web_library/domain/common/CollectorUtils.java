package com.github.dkurata38.open_web_library.domain.common;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorUtils {
	/**
	 * リストを特定のキーでグルーピングし、キーと元のリストを加工したリストが対になったMapを返却する。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * リストの加工ロジックは第三引数で与えられた関数オブジェクトに従う。<br>
	 * @param list グルーピング対象のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param valueExtractor リストの要素から値を取得する関数オブジェクト
	 * @param <S> 集計元のリストの型
	 * @param <K> キーの型。Comparableインターフェースを実装したクラスである必要がある
	 * @param <V> 集計結果の型
	 * @return グルーピング結果
	 */
	public static <S, K, V> Map<K, List<V>> groupingBy(List<S> list, Function<S, K> keyExtractor, Function<S, V> valueExtractor) {
		return list.stream()
				.collect(Collectors.groupingBy(keyExtractor, Collectors.mapping(valueExtractor, Collectors.toList())));
	}

	/**
	 * リストを特定のキーでグルーピングし、キーと元のリストを加工したリストが対になったオブジェクトのリストを返却する。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * リストの加工ロジックは第三引数で与えられた関数オブジェクトに従う。<br>
	 * グルーピングしたキーと結果からオブジェクトを生成するロジックは第四引数で与えられた関数オブジェクトに従う。<br>
	 * @param list グルーピング対象のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param valueExtractor リストの要素から値を取得する関数オブジェクト
	 * @param resultFactory キーと集計結果から戻り値のリスト要素を生成する関数オブジェクト
	 * @param <S> 集計元のリストの型
	 * @param <K> 集計キーの型
	 * @param <V> 集計結果の型
	 * @param <R> 戻り値のリストの型
	 * @return 集計結果
	 */
	public static <S, K, V, R> List<R> groupingBy(List<S> list, Function<S, K> keyExtractor, Function<S, V> valueExtractor, BiFunction<K, List<V>, R> resultFactory) {
		return groupingBy(list, keyExtractor, valueExtractor)
				.entrySet()
				.stream()
				.map(entry -> resultFactory.apply(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}

	/**
	 * リストを特定のキーでグルーピングし、キーとリストが対になったMapを返却する。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * 内部では{@link CollectorUtils#groupingBy(List, Function, Function)}の第三引数に{@link Function#identity()}を指定して呼び出している。<br>
	 * @param list グルーピング対象のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param <K> キーの型。Comparableインターフェースを実装したクラスである必要がある
	 * @param <V> リストの要素の型
	 * @return グルーピング結果
	 */
	public static <K, V> Map<K, List<V>> groupingBy(List<V> list, Function<V, K> keyExtractor) {
		return groupingBy(list, keyExtractor, Function.identity());
	}

	/**
	 * リストを特定のキーでグルーピングし、キーとリストが対になったMapを返却する。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * 内部では{@link CollectorUtils#groupingBy(List, Function, Function)}の第三引数に{@link Function#identity()}を指定して呼び出している。<br>
	 * @param list グルーピング対象のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param resultFactory キーと集計結果から戻り値のリスト要素を生成する関数オブジェクト
	 * @param <K> キーの型。Comparableインターフェースを実装したクラスである必要がある
	 * @param <V> リストの要素の型
	 * @param <R> 戻り値のリストの型
	 * @return グルーピング結果
	 */
	public static <K, V, R> List<R> groupingBy(List<V> list, Function<V, K> keyExtractor, BiFunction<K, List<V>, R> resultFactory) {
		return groupingBy(list, keyExtractor, Function.identity())
				.entrySet()
				.stream()
				.map(entry -> resultFactory.apply(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}

	/**
	 * リストをMapに変換する。<br>
	 * 同一のキーが含まれていた場合は、リストの後の要素がバリューとして評価される。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * バリューの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * @param list 変換元のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param valueExtractor 変換元のリストの要素を変換後のMapのバリューを取得する関数オブジェクト
	 * @param <S> 集計元のリストの型
	 * @param <K> キーの型。Comparableインターフェースを実装したクラスである必要がある
	 * @param <V> 集計結果の型
	 * @return 変換結果
	 */
	public static <S, K, V> Map<K, V> toMap(List<S> list, Function<S, K> keyExtractor, Function<S, V> valueExtractor) {
		return list.stream()
				.collect(Collectors.toMap(keyExtractor, valueExtractor, (v, v2) -> v2));
	}

	/**
	 * リストをMapに変換する。<br>
	 * 同一のキーが含まれていた場合は、リストの後の要素がバリューとして評価される。<br>
	 * キーの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * バリューの生成ロジックは第二引数で与えられた関数オブジェクトに従う。<br>
	 * @param list 変換元のリスト
	 * @param keyExtractor リストの要素からリストのキーを取得する関数オブジェクト
	 * @param <V> 変換元のリストの型。変換後のバリューの型。
	 * @param <K> キーの型。Comparableインターフェースを実装したクラスである必要がある
	 * @return 変換結果
	 */
	public static <K, V> Map<K, V> toMap(List<V> list, Function<V, K> keyExtractor) {
		return list.stream()
				.collect(Collectors.toMap(keyExtractor, Function.identity(), (v, v2) -> v2));
	}

	public static <Entity, Property> List<Property> collect(List<Entity> entityList, Function<Entity, Property> getter){
		return entityList.stream()
				.map(getter)
				.collect(Collectors.toList());
	}
}
